package xyz.marcelo.ml;

import java.util.ArrayList;
import java.util.List;

import org.encog.mathutil.probability.CalcProbability;
import org.encog.ml.bayesian.BayesianEvent;
import org.encog.ml.bayesian.BayesianNetwork;
import org.encog.ml.bayesian.EventType;
import org.encog.ml.bayesian.query.enumerate.EnumerationQuery;
import org.encog.util.text.BagOfWords;

public class BayesianClassifier {

	private String[] HAM_DATA;
	private String[] SPAM_DATA;

	private int k;

	private BagOfWords spamBag;
	private BagOfWords hamBag;
	private BagOfWords totalBag;

	public BayesianClassifier(int theK, String[] hamData, String[] spamData) {

		this.k = theK;
		this.HAM_DATA = hamData;
		this.SPAM_DATA = spamData;

		this.hamBag = new BagOfWords(this.k);
		this.spamBag = new BagOfWords(this.k);
		this.totalBag = new BagOfWords(this.k);

		for (String line : this.HAM_DATA) {
			this.hamBag.process(line);
			this.totalBag.process(line);
		}

		for (String line : this.SPAM_DATA) {
			this.spamBag.process(line);
			this.totalBag.process(line);
		}

		this.hamBag.setLaplaceClasses(this.totalBag.getUniqueWords());
		this.spamBag.setLaplaceClasses(this.totalBag.getUniqueWords());
	}

	public List<String> separateSpaces(String str) {

		List<String> result = new ArrayList<String>();
		StringBuilder word = new StringBuilder();

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (ch != '\'' && !Character.isLetterOrDigit(ch)) {
				if (word.length() > 0) {
					result.add(word.toString());
					word.setLength(0);
				}
			} else {
				word.append(ch);
			}
		}

		if (word.length() > 0) {
			result.add(word.toString());
		}

		return result;
	}

	public double probabilitySpam(String m) {

		List<String> words = separateSpaces(m);

		BayesianNetwork network = new BayesianNetwork();
		BayesianEvent spamEvent = network.createEvent("spam");

		int index = 0;
		for (String word : words) {
			BayesianEvent event = network.createEvent(word + index);
			network.createDependency(spamEvent, event);
			index++;
		}

		network.finalizeStructure();

		// SamplingQuery query = new SamplingQuery(network);
		EnumerationQuery query = new EnumerationQuery(network);

		CalcProbability messageProbability = new CalcProbability(this.k);
		messageProbability.addClass(this.SPAM_DATA.length);
		messageProbability.addClass(this.HAM_DATA.length);
		double probSpam = messageProbability.calculate(0);

		spamEvent.getTable().addLine(probSpam, true);
		query.defineEventType(spamEvent, EventType.Outcome);
		query.setEventValue(spamEvent, true);

		index = 0;
		for (String word : words) {
			String word2 = word + index;
			BayesianEvent event = network.getEvent(word2);
			event.getTable().addLine(this.spamBag.probability(word), true, true); // spam
			event.getTable().addLine(this.hamBag.probability(word), true, false); // ham
			query.defineEventType(event, EventType.Evidence);
			query.setEventValue(event, true);
			index++;
		}

		// query.setSampleSize(100000000);
		query.execute();
		return query.getProbability();
	}

}