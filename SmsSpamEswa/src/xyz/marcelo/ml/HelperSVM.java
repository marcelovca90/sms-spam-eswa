/*******************************************************************************
 * Copyright (C) 2016 Marcelo Vinícius Cysneiros Aragão
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 ******************************************************************************/
package xyz.marcelo.ml;

import java.util.LinkedList;

import org.encog.ml.data.MLDataSet;
import org.encog.ml.svm.KernelType;
import org.encog.ml.svm.SVM;
import org.encog.ml.svm.SVMType;
import org.encog.ml.svm.training.SVMTrain;
import org.encog.neural.data.basic.BasicNeuralDataSet;

import xyz.marcelo.data.SmsMessage;
import xyz.marcelo.stat.StatisticsAggregator;

public class HelperSVM
{
    public static double[][] buildInput(LinkedList<SmsMessage> data, int Nf, LinkedList<String> trainTotalTopWords)
    {
        double[][] ans = new double[data.size()][Nf];
        for (int i = 0; i < data.size(); i++)
            for (int j = 0; j < Nf; j++)
                ans[i][j] = data.get(i).getWords().contains(trainTotalTopWords.get(j)) ? 1 : 0;
        return ans;
    }

    public static double[][] buildOutput(LinkedList<SmsMessage> data)
    {
        double[][] ans = new double[data.size()][];
        for (int i = 0; i < data.size(); i++)
            ans[i] = data.get(i).getType().equals("ham") ? new double[] { 0 } : new double[] { 1 };
        return ans;
    }

    public static void run(String config, int Ld, int Nf, LinkedList<SmsMessage> trainData, LinkedList<SmsMessage> testData, LinkedList<String> trainHamTopWords, LinkedList<String> trainSpamTopWords, LinkedList<String> trainTotalTopWords)
    {
        double[][] x_train_svm = buildInput(trainData, Nf, trainTotalTopWords);
        double[][] x_test_svm = buildInput(testData, Nf, trainTotalTopWords);

        double[][] d_train_svm = buildOutput(trainData);
        double[][] d_test_svm = buildOutput(testData);

        MLDataSet trainSetSvm = new BasicNeuralDataSet(x_train_svm, d_train_svm);
        MLDataSet testSetSvm = new BasicNeuralDataSet(x_test_svm, d_test_svm);

        SVM svm = new SVM(Nf, SVMType.SupportVectorClassification, KernelType.RadialBasisFunction);

        SVMTrain svmTrain = new SVMTrain(svm, trainSetSvm);
        svmTrain.setC(1e+3);
        svmTrain.setGamma(1.0 / (x_train_svm[0].length));

        svmTrain.iteration();

        StatisticsAggregator.evaluate(config, svm, testSetSvm, Ld);
    }
}
