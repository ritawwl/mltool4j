package edu.thu.mltool4j.topicmodel.plsa;

import java.io.File;

import edu.thu.mltool4j.data.Dataset;
import edu.thu.mltool4j.utils.ErrorReport;

public class ProbabilisticLSA
{
	private Dataset dataset = null;
	private int M = -1;
	private int V = -1;
	private int K = -1;

	// p(z), size: K
	private double[] Pz = null;

	// p(d|z), size: K x M
	private double[][] Pd_z = null;

	// p(w|z), size: K x V
	private double[][] Pw_z = null;
	
	// p(z|d,w), size: M x V x K
	private double[][][] Pz_dw = null;

	// L: log-likelihood value
	private double L = -1;

	public ProbabilisticLSA(String datafileName)
	{
		File datafile = new File(datafileName);
		if (datafile.exists())
		{
			dataset = new Dataset(datafile);
		}
		else
		{
			ErrorReport.showMessage(this,
					"ProbabilisticLSA(String datafileName)", "datafile: "
							+ datafileName + " doesn't exist");
		}
	}

	private boolean init()
	{
		if (dataset != null)
		{
			this.M = dataset.getDataNum();
			this.V = dataset.getFeatureNum();

			// random initialize probability
			
			return true;
		}
		else
		{
			return false;
		}
	}

	private boolean EM()
	{
		return false;
	}

	private boolean Estep()
	{
		return false;
	}

	private boolean Mstep()
	{
		return false;
	}

	private double calcLoglikelihood()
	{
		return -1;
	}
}
