package xyz.marcelo.main;

import java.util.HashMap;
import java.util.LinkedList;

import org.encog.Encog;

import xyz.marcelo.common.Constants;
import xyz.marcelo.data.SmsMessage;
import xyz.marcelo.data.StringProcessor;
import xyz.marcelo.ml.HelperNB;
import xyz.marcelo.ml.HelperSVM;
import xyz.marcelo.stat.StatisticsAggregator;

public class Main {

	public static void main(String[] args) throws Exception {

		// 0 - inicializacao do processador de strings

		StringProcessor.initialize();

		for (String[] configParams : Constants.CONFIGS) {
			// 1 - leitura dos parametros da configuracao

			String config = String.format("%s\t%s\t%s\t%s\t%s", configParams[0], configParams[1], configParams[2],
					configParams[3], configParams[4]);

			boolean Sw = configParams[0].equalsIgnoreCase("yes");
			boolean Lz = configParams[1].equalsIgnoreCase("yes");
			int Ld = Integer.parseInt(configParams[2]);
			int Nf = Integer.parseInt(configParams[3]);
			String Cl = configParams[4].toUpperCase();

			// 2 - leitura do data set (arquivo) e construcao da lista de
			// mensagens

			LinkedList<SmsMessage> smsData = StringProcessor.readFile(Constants.DATA_FILE_PATH);

			for (int batch = 0; batch < Constants.NUMBER_OF_REPEATS; batch++) {
				// 3 - embaralhamento a lista de mensagens

				smsData = StringProcessor.shuffle(smsData);

				// 4.1 - construcao do conjunto de treinamento

				LinkedList<SmsMessage> trainSmsData = new LinkedList<SmsMessage>();
				for (int i = 0; i < 70 * smsData.size() / 100; i++)
					trainSmsData.add(smsData.get(i));

				HashMap<String, Integer> trainHamDictionary = StringProcessor.buildDictionary(trainSmsData, "ham");
				HashMap<String, Integer> trainSpamDictionary = StringProcessor.buildDictionary(trainSmsData, "spam");
				HashMap<String, Integer> trainTotalDictionary = StringProcessor.buildDictionary(trainSmsData, "all");

				// 4.2 - construcao do conjunto de teste

				LinkedList<SmsMessage> testSmsData = new LinkedList<SmsMessage>();
				for (int i = 70 * smsData.size() / 100; i < smsData.size(); i++)
					testSmsData.add(smsData.get(i));

				if (Sw) // 5 - retirada das stop-words
				{
					trainHamDictionary = StringProcessor.removeStopWords(trainHamDictionary);
					trainSpamDictionary = StringProcessor.removeStopWords(trainSpamDictionary);
					trainTotalDictionary = StringProcessor.removeStopWords(trainTotalDictionary);
				}

				if (Lz) // 6 - aplicacao da lematizacao
						// (http://stanfordnlp.github.io/CoreNLP/)
				{
					trainHamDictionary = StringProcessor.lemmatizeDictionary(trainHamDictionary);
					trainSpamDictionary = StringProcessor.lemmatizeDictionary(trainSpamDictionary);
					trainTotalDictionary = StringProcessor.lemmatizeDictionary(trainTotalDictionary);
				}

				// 7 - geracao das listas das palavras mais comuns

				LinkedList<String> trainHamTopWords = StringProcessor.getTopWords(trainHamDictionary, Nf);
				LinkedList<String> trainSpamTopWords = StringProcessor.getTopWords(trainSpamDictionary, Nf);
				LinkedList<String> trainTotalTopWords = StringProcessor.getTopWords(trainTotalDictionary, Nf);

				// 8 - execucao da tecnica (treinamento e teste)

				switch (Cl) {
				case "NB":
					HelperNB.run(config, Ld, Nf, trainSmsData, testSmsData, trainHamTopWords, trainSpamTopWords,
							trainTotalTopWords);
					break;
				case "SVM":
					HelperSVM.run(config, Ld, Nf, trainSmsData, testSmsData, trainHamTopWords, trainSpamTopWords,
							trainTotalTopWords);
					break;
				}
			}

			// 9 - reportando estatisticas
			StatisticsAggregator.report();
		}

		// 10 - desligando a instancia do encog
		Encog.getInstance().shutdown();
	}

}
