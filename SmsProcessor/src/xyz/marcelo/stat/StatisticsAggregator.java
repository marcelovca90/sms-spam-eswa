package xyz.marcelo.stat;


import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map.Entry;

import org.encog.ml.data.MLDataPair;
import org.encog.ml.data.MLDataSet;
import org.encog.ml.svm.SVM;

import xyz.marcelo.common.Constants;
import xyz.marcelo.ml.BayesianClassifier;


public class StatisticsAggregator {

	private static LinkedHashMap<String, LinkedHashMap<String, LinkedList<Double>>> results = 
			new LinkedHashMap<String, LinkedHashMap<String, LinkedList<Double>>>();
	
	private static HashSet<String> alreadyPrinted = new HashSet<String>();
	
	private static StringBuffer buffer = new StringBuffer();

	public static void evaluate(String config, BayesianClassifier bc, String[] samples, String[] types, int lambda) {

		int NL = 0, NS = 0;
		int nss = 0, nsl = 0, nll = 0, nls = 0;
		long classTime = 0;
		long start = 0, end = 0;

		// conta quantidade de hams e spams
		for (int i=0; i<samples.length; i++) 
		{
			start = System.currentTimeMillis();
			double chance = bc.probabilitySpam(samples[i]);
			end = System.currentTimeMillis();
			classTime += (end - start);
			
			if (types[i].equalsIgnoreCase("ham")) 
			{
				NL++;
				if (Double.compare(chance, 0.5) < 0)
					nll++;
				else
					nls++;
			}
			else 
			{
				NS++;
				if (Double.compare(chance, 0.5) >= 0)
					nss++;
				else
					nsl++;
			}
		}
		
		calculate(config,NL, NS, nss, nsl, nll, nls, lambda, classTime);
	}
	
	public static void evaluate(String config, SVM svm, MLDataSet testSet, int lambda) {

		int NL = 0, NS = 0;
		int nss = 0, nsl = 0, nll = 0, nls = 0;
		long classTime = 0;
		long start = 0, end = 0;

		// conta quantidade de hams e spams
		for (MLDataPair pair : testSet)
		{
			start = System.currentTimeMillis();
			int outputClass = svm.classify(pair.getInput());
			end = System.currentTimeMillis();
			classTime += (end - start);
			
			if (Double.compare(pair.getIdeal().getData(0), 0) == 0)
			{
				NL++;
				if (outputClass == 0)
					nll++;
				else
					nls++;
			}
			else
			{
				NS++;
				if (outputClass == 0)
					nsl++;
				else
					nss++;
			}
		}
		
		calculate(config, NL, NS, nss, nsl, nll, nls, lambda, classTime);
	}
	
	public static void calculate(String config, int NL, int NS, int nss, int nsl, int nll, int nls, int lambda, long classTime) {
		
		boolean flagNaN = false;
		
		// ham precision
		double hamPrecision = (double)(nll) / (double)(nll+nsl);
		if (Double.isNaN(hamPrecision)) { flagNaN = true; }

		// ham recall
		double hamRecall = (double)(nll) / (double)(nll+nls);
		if (Double.isNaN(hamRecall)) { flagNaN = true; }
		
		// spam precision
		double spamPrecision = (double)(nss) / (double)(nss+nls);
		if (Double.isNaN(spamPrecision)) { flagNaN = true; }
		
		// spam recall
		double spamRecall = (double)(nss) / (double)(nss+nsl);
		if (Double.isNaN(spamRecall)) { flagNaN = true; }
		
		// weighted accuracy
		double acc = (double)(nll + nss) / (double)(NL + NS);
		if (Double.isNaN(acc)) { flagNaN = true; }
		double err = (double)(nls + nsl) / (double)(NL + NS);
		if (Double.isNaN(err)) { flagNaN = true; }
		double wAcc = (double)((lambda * nll) + nss) / (double)((lambda * NL) + NS);
		if (Double.isNaN(wAcc)) { flagNaN = true; }
		double wErr = (double)((lambda * nls) + nsl) / (double)((lambda * NL) + NS);
		if (Double.isNaN(wErr)) { flagNaN = true; }
		
		// total cost ratio
		double wAcc_b = (double)(lambda * NL) / (double)((lambda * NL) + NS);
		if (Double.isNaN(wAcc_b)) { flagNaN = true; }
		double wErr_b = (double)(lambda * NS) / (double)((lambda * NL) + NS);
		if (Double.isNaN(wErr_b)) { flagNaN = true; }
		double tcr = (wErr_b / wErr);
		if (Double.isNaN(tcr)) { flagNaN = true; }
		
		// f-measure
		double fMeasure = 4.0 * ((hamPrecision * hamRecall * spamPrecision * spamRecall) / (hamPrecision + hamRecall + spamPrecision + spamRecall));
		if (Double.isNaN(fMeasure)) { flagNaN = true; }
		
		if (flagNaN)
		{
			System.out.println("!!! NaN FOUND !!!");
			System.out.println("config = " + config);
			System.out.println("NL = " + NL);
			System.out.println("NS = " + NS);
			System.out.println("nss = " + nss);
			System.out.println("nsl = " + nsl);
			System.out.println("nll = " + nll);
			System.out.println("nls = " + nls);
			System.out.println("lambda = " + lambda);
			System.out.println("classTime = " + classTime);
			System.out.println("hamPrecision = " + hamPrecision);
			System.out.println("hamRecall = " + hamRecall);
			System.out.println("spamPrecision = " + spamPrecision);
			System.out.println("spamRecall = " + spamRecall);
			System.out.println("acc = " + acc);
			System.out.println("err = " + err);
			System.out.println("wAcc = " + wAcc);
			System.out.println("wErr = " + wErr);
			System.out.println("wAcc_b = " + wAcc_b);
			System.out.println("wErr_b = " + wErr_b);
			System.out.println("tcr = " + tcr);
			System.out.println("fMeasure = " + fMeasure);
		}
		
		if (!results.containsKey(config))
		{
			results.put(config, new LinkedHashMap<String, LinkedList<Double>>());
			results.get(config).put("hamPrecision", new LinkedList<Double>());
			results.get(config).put("hamRecall", new LinkedList<Double>());
			results.get(config).put("spamPrecision", new LinkedList<Double>());
			results.get(config).put("spamRecall", new LinkedList<Double>());
			results.get(config).put("err", new LinkedList<Double>());
			results.get(config).put("acc", new LinkedList<Double>());
			results.get(config).put("wErr", new LinkedList<Double>());
			results.get(config).put("wAcc", new LinkedList<Double>());
			results.get(config).put("tcr", new LinkedList<Double>());
			results.get(config).put("fMeasure", new LinkedList<Double>());
			results.get(config).put("classTime", new LinkedList<Double>());
		}
		
		results.get(config).get("hamPrecision").add(100.0 * hamPrecision);
		results.get(config).get("hamRecall").add(100.0 * hamRecall);
		results.get(config).get("spamPrecision").add(100.0 * spamPrecision);
		results.get(config).get("spamRecall").add(100.0 * spamRecall);
		results.get(config).get("err").add(100.0 * err);
		results.get(config).get("acc").add(100.0 * acc);
		results.get(config).get("wErr").add(100.0 * wErr);
		results.get(config).get("wAcc").add(100.0 * wAcc);
		results.get(config).get("tcr").add(100.0 * tcr);
		results.get(config).get("fMeasure").add(100.0 * fMeasure);
		results.get(config).get("classTime").add((double)classTime);
	}
	
	public static void report() {
		
		if (!alreadyPrinted.contains(Constants.METRICS_HEADER))
		{
			System.out.println(Constants.METRICS_HEADER);
			alreadyPrinted.add(Constants.METRICS_HEADER);
		}
		
		for (Entry<String, LinkedHashMap<String, LinkedList<Double>>> i : results.entrySet())
		{
			String config = i.getKey();
			buffer.append(config);
			for (Entry<String, LinkedList<Double>> j : i.getValue().entrySet())
			{
				double sum = 0.0, avg;
				for (Double k : j.getValue())
					sum += k;
				avg = (sum / (double)j.getValue().size());
				buffer.append(String.format("\t%.3f", avg));
			}
			if (!alreadyPrinted.contains(buffer.toString()))
			{
				System.out.println(buffer.toString());
				alreadyPrinted.add(buffer.toString());
			}
			buffer.setLength(0);
		}
	}

}