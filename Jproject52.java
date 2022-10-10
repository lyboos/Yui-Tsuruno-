import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ArffLoader;
import weka.filters.unsupervised.attribute.Normalize;
import weka.filters.unsupervised.attribute.ReplaceMissingValues;
import weka.filters.unsupervised.attribute.Standardize;

import java.io.File;

public class NaiveBayes{
    public static void main(String[] args) {
        Instances ins = null;
        Classifier cfs = null;
        try {
            // read the training set
            File file = new File("./adult_income_uk.arff");
            ArffLoader loader = new ArffLoader();
            loader.setFile(file);
            ins = loader.getDataSet();
            //System.out.println(ins.numAttributes());
            ins.setClassIndex(ins.numAttributes() - 1);


            //预处理
            ReplaceMissingValues replaceMissingValues = new ReplaceMissingValues();
            replaceMissingValues.setInputFormat(ins);
            ins = ReplaceMissingValues.useFilter(ins, replaceMissingValues);
            Standardize standardize = new Standardize();
            standardize.setInputFormat(ins);
            ins = Standardize.useFilter(ins, standardize);
            Normalize normalize = new Normalize();
            normalize.setInputFormat(ins);
            ins = Normalize.useFilter(ins, normalize);

            //分划数据集
            int trainSize = (int)(ins.numInstances() * 0.8);
            int testSize = ins.numInstances() - trainSize;
            Instances trainData = new Instances(ins, 0, trainSize);
            Instances testData = new Instances(ins, trainSize, testSize);


            // 初始化分类器
            cfs = (Classifier) Class.forName("weka.classifiers.bayes.NaiveBayes").newInstance();

            // 使用训练集对数据集训练
            cfs.buildClassifier(trainData);

            // 使用测试数据集测试分类器的性能
            Instance testInst=null;
            Evaluation testingEvaluation = new Evaluation(trainData);
            int length2=trainSize;
            int length1 = testSize; //得到数据集样本个数
            System.out.println("train data length:"+length2);
            System.out.println("test data length:"+length1);
            for (int i = 0; i < length1; i++) {
                testInst = testData.instance(i);
                testingEvaluation.evaluateModelOnceAndRecordPrediction(cfs, testInst);
            }

             //print the classifying results
            System.out.println("分类正确率:" + (1 - testingEvaluation.errorRate()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
