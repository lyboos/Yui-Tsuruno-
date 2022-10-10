import weka.attributeSelection.AttributeSelection;
import weka.attributeSelection.PrincipalComponents;
import weka.attributeSelection.Ranker;
import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import weka.core.*;
import weka.core.converters.ArffLoader;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.AddID;

import java.io.File;
import java.util.Arrays;

public class PCA {
    public static void main(String[] args) {
        Instances ins = null;
        try {
            // read the training set
            File file = new File("./titanic.arff");
            ArffLoader loader = new ArffLoader();
            loader.setFile(file);
            ins = loader.getDataSet();

            //PCA
            AttributeSelection selector = new AttributeSelection();
            PrincipalComponents pca = new PrincipalComponents();
            Ranker ranker = new Ranker();
            pca.setCenterData(true);
            ranker.setNumToSelect(5);

            selector.setSearch(ranker);
            selector.setEvaluator(pca);

            selector.SelectAttributes(ins);
            selector.reduceDimensionality(ins);

            System.out.println("after dimensionReduce:");
            System.out.println(selector.toResultsString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
