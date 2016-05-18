package xyz.marcelo.data;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Properties;


import edu.stanford.nlp.ling.CoreAnnotations.LemmaAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.SentencesAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.TokensAnnotation;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.util.CoreMap;

@SuppressWarnings("unchecked")
public class StringProcessor {

	private static Properties props;
	private static StanfordCoreNLP pipeline;
	public static String[] stopWords;

	public static LinkedList<SmsMessage> readFile(String path) throws IOException {
		
		LinkedList<SmsMessage> smsData = new LinkedList<SmsMessage>();
		
		File dataFile = new File(path);
		FileReader fileReader = new FileReader(dataFile);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		
		String line;
		while ((line = bufferedReader.readLine()) != null) 
		{
			String type = line.substring(0, line.indexOf('\t'));
			String text = normalizeString(line.substring(line.indexOf('\t') + 1));
			LinkedList<String> words = splitString(text);
			smsData.add(new SmsMessage(type, text, words));
		};
		bufferedReader.close();
		
		return smsData;
	}
	
	
	public static void initialize() {
		
		// Create StanfordCoreNLP object properties, with POS tagging
		// (required for lemmatization), and lemmatization
		props = new Properties();
		props.put("annotators", "tokenize, ssplit, pos, lemma");

		// StanfordCoreNLP loads a lot of models, so you probably
		// only want to do this once per execution
		pipeline = new StanfordCoreNLP(props);

		// http://www.ranks.nl/stopwords
		stopWords = new String[] { "a", "about", "above", "after", "again",
				"against", "all", "am", "an", "and", "any", "are", "arent",
				"as", "at", "be", "because", "been", "before", "being",
				"below", "between", "both", "but", "by", "cant", "cannot",
				"could", "couldnt", "did", "didnt", "do", "does", "doesnt",
				"doing", "dont", "down", "during", "each", "few", "for",
				"from", "further", "had", "hadnt", "has", "hasnt", "have",
				"havent", "having", "he", "hed", "hell", "hes", "her", "here",
				"heres", "hers", "herself", "him", "himself", "his", "how",
				"hows", "i", "id", "ill", "im", "ive", "if", "in", "into",
				"is", "isnt", "it", "its", "its", "itself", "lets", "me",
				"more", "most", "mustnt", "my", "myself", "no", "nor", "not",
				"of", "off", "on", "once", "only", "or", "other", "ought",
				"our", "ours	ourselves", "out", "over", "own", "same", "shant",
				"she", "shed", "shell", "shes", "should", "shouldnt", "so",
				"some", "such", "than", "that", "thats", "the", "their",
				"theirs", "them", "themselves", "then", "there", "theres",
				"these", "they", "theyd", "theyll", "theyre", "theyve", "this",
				"those", "through", "to", "too", "under", "until", "up",
				"very", "was", "wasnt", "we", "wed", "well", "were", "weve",
				"were", "werent", "what", "whats", "when", "whens", "where",
				"wheres", "which", "while", "who", "whos", "whom", "why",
				"whys", "with", "wont", "would", "wouldnt", "you", "youd",
				"youll", "youre", "youve", "your", "yours", "yourself",
				"yourselves" };
	}
	
	public static HashMap<String, Integer> buildDictionary(LinkedList<SmsMessage> smsData, String type) {
		
		HashMap<String, Integer> dictionary = new HashMap<String, Integer>();
		
		Iterator<SmsMessage> messageIterator = smsData.iterator();

		while (messageIterator.hasNext())
		{
			SmsMessage smsMessage = messageIterator.next();
			if (smsMessage.getType().equalsIgnoreCase(type) || type.equalsIgnoreCase("all"))
			{
				String normalizedText = StringProcessor.normalizeString(smsMessage.getText());
				LinkedList<String> words = StringProcessor.splitString(normalizedText);
				for (String word : words)
				{
					if (!dictionary.containsKey(word))
						dictionary.put(word, 0);
					dictionary.put(word, dictionary.get(word) + 1);
				}
			}
		}
		
		return dictionary;		
	}

	public static String normalizeString(String text) {

		String temp = text;

		// substitui letras acentuadas pelas originais
		temp = Normalizer.normalize(temp, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");

		// separa todos os numeros e palavras
		temp = temp.replaceAll("\\d+", " _NUMBER_ ");

		// remove caracteres estranhos da mensagem
		temp = temp.replaceAll("[^\\w\\s_]", " ");

		// tira todos os excessos de espaços
		temp = temp.replaceAll("\\s+", " ").trim().toLowerCase();

		return temp;
	}
	
	public static LinkedList<String> splitString(String text) {
		
		LinkedList<String> wordList = new LinkedList<String>();
		for (String word : text.split("\\s+"))
			if (word != null && !word.isEmpty())
				wordList.add(word);
		return wordList;
	}

	public static LinkedList<String> lemmatizeString(String text) {
		
		LinkedList<String> lemmas = new LinkedList<String>();

		// create an empty Annotation just with the given text
		Annotation document = new Annotation(text);

		// run all Annotators on this text
		pipeline.annotate(document);
		// Iterate over all of the sentences found
		List<CoreMap> sentences = document.get(SentencesAnnotation.class);
		for (CoreMap sentence : sentences) {
			// Iterate over all tokens in a sentence
			for (CoreLabel token : sentence.get(TokensAnnotation.class)) {
				// Retrieve and add the lemma for each word into the
				// list of lemmas
				lemmas.add(token.get(LemmaAnnotation.class));
			}
		}
		return lemmas;
	}
	
	public static HashMap<String, Integer> lemmatizeDictionary(HashMap<String, Integer> dictionary) {
		
		HashMap<String, Integer> clonedDictionary = (HashMap<String, Integer>)dictionary.clone();
		List<String> toBeRemoved = new ArrayList<String>();
		HashMap<String, Integer> toBeInserted = new HashMap<String, Integer>();
		
		for (String word : clonedDictionary.keySet()) {
			String lemma = StringProcessor.lemmatizeString(word).get(0);
			if (word.compareToIgnoreCase(lemma) != 0) {
				Integer wordCount = clonedDictionary.get(word);
				toBeRemoved.add(word);
				Integer lemmaCount = clonedDictionary.containsKey(lemma) ? clonedDictionary.get(lemma) : 0;
				toBeInserted.put(lemma, wordCount + lemmaCount);
			}
		}
		for (String word : toBeRemoved)
			clonedDictionary.remove(word);
		for (Entry<String, Integer> entry : toBeInserted.entrySet())
			clonedDictionary.put(entry.getKey(), entry.getValue());
		
		return clonedDictionary;		
	}
	
	public static HashMap<String, Integer> removeStopWords(HashMap<String, Integer> dictionary) {
		
		HashMap<String, Integer> clonedDictionary = (HashMap<String, Integer>)dictionary.clone();
		
		for (String stopWord : stopWords)
			if (clonedDictionary.containsKey(stopWord))
				clonedDictionary.remove(stopWord);
		
		return clonedDictionary;		
	}
	
	public static LinkedList<String> getTopWords(HashMap<String, Integer> dictionary, int amount) {
		
		HashMap<String, Integer> clonedDictionary = (HashMap<String, Integer>)dictionary.clone();
		LinkedList<String> topWords = new LinkedList<String>();
		
		for (int i = 0; i < amount; i++) {
			String tempWord = "";
			Integer tempMax = Integer.MIN_VALUE;
			for (Entry<String, Integer> entry : clonedDictionary.entrySet()) {
				if (entry.getValue() > tempMax) {
					tempMax = entry.getValue();
					tempWord = entry.getKey();
				}
			}
			topWords.add(tempWord);
			clonedDictionary.remove(tempWord);
		}
		
		return topWords;
	}
	
	public static LinkedList<SmsMessage> shuffle(LinkedList<SmsMessage> list) {
		
		LinkedList<SmsMessage> clonedList = (LinkedList<SmsMessage>)list.clone();
		SmsMessage backup;
		
		for (int i=clonedList.size()-1; i>=1; i--) {
			int j = (int)(Math.random() * ((double)i));
			backup = clonedList.get(i);
			clonedList.set(i, clonedList.get(j));
			clonedList.set(j, backup);
		}
		
		return clonedList;		
	}
	
}
