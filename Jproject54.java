import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import weka.clusterers.ClusterEvaluation;
import weka.clusterers.SimpleKMeans;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ArffLoader;

import java.io.File;

public class KMeans {
    public static void main(String[] args) {
        Instances ins = null;
        try {
            // read the training set
            File file = new File("./iris.arff");
            ArffLoader loader = new ArffLoader();
            loader.setFile(file);
            ins = loader.getDataSet();

            SimpleKMeans kMeans = new SimpleKMeans();
            kMeans.setNumClusters(3);
            kMeans.buildClusterer(ins);
            ClusterEvaluation eval = new ClusterEvaluation();
            eval.setClusterer(kMeans);
            eval.evaluateClusterer(ins);
            System.out.println(eval.clusterResultsToString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
