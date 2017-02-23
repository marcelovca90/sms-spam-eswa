package xyz.marcelo.ml;

import java.util.LinkedList;

import xyz.marcelo.data.SmsMessage;
import xyz.marcelo.stat.StatisticsAggregator;

public class HelperNB
{
    public static String[] buildInput(LinkedList<SmsMessage> data, int Nf, LinkedList<String> trainTotalTopWords)
    {
        String[] ans = new String[data.size()];
        for (int i = 0; i < data.size(); i++)
        {
            ans[i] = "";
            for (int j = 0; j < Nf; j++)
                if (data.get(i).getWords().contains(trainTotalTopWords.get(j))) ans[i] += (trainTotalTopWords.get(j) + " ");
        }
        return ans;
    }

    public static String[] buildOutput(LinkedList<SmsMessage> data)
    {
        String[] ans = new String[data.size()];
        for (int i = 0; i < data.size(); i++)
            ans[i] = data.get(i).getType();
        return ans;
    }

    public static void run(String config, int Ld, int Nf, LinkedList<SmsMessage> trainData, LinkedList<SmsMessage> testData,
            LinkedList<String> trainHamTopWords, LinkedList<String> trainSpamTopWords, LinkedList<String> trainTotalTopWords)
    {
        // 9 - Bayesian Network
        // http://www.programcreek.com/java-api-examples/index.php?api=org.encog.ml.bayesian.BayesianNetwork
        // http://www.programcreek.com/java-api-examples/index.php?source_dir=encog-java-examples-master/src/main/java/org/encog/examples/ml/bayesian/BayesianSpam.java

        BayesianClassifier bayes = new BayesianClassifier(0, trainHamTopWords.toArray(new String[trainHamTopWords.size()]),
                trainSpamTopWords.toArray(new String[trainSpamTopWords.size()]));

        String[] x_test_bayes = buildInput(testData, Nf, trainTotalTopWords);
        String[] d_test_bayes = buildOutput(testData);

        StatisticsAggregator.evaluate(config, bayes, x_test_bayes, d_test_bayes, Ld);
    }
}
