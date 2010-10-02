package edu.thu.mltool4j.topicmodel.plsa;

import java.io.File;

import edu.thu.mltool4j.data.Data;
import edu.thu.mltool4j.data.Dataset;
import edu.thu.mltool4j.utils.ErrorReport;

public class ProbabilisticLSA
{
	private Dataset dataset = null;
	private int M = -1;
	private int V = -1;
	private int K = -1;

	public ProbabilisticLSA()
	{

	}

	public boolean doPLSA(String datafileName, int ntopics, int iters)
	{
		File datafile = new File(datafileName);
		if (datafile.exists())
		{
			if ((dataset = new Dataset(datafile)) == null)
			{
				ErrorReport.showMessage(this, "doPLSA", "dataset == null");
				return false;
			}
			this.M = dataset.getDataNum();
			this.V = dataset.getFeatureNum();
			this.K = ntopics;

			//run EM algorithm
			this.EM(iters);

			return true;
		}
		else
		{
			ErrorReport.showMessage(this,
					"ProbabilisticLSA(String datafileName)", "datafile: "
							+ datafileName + " doesn't exist");
			return false;
		}
	}

	private boolean EM(int iters)
	{
		// p(z), size: K
		double[] Pz = new double[this.K];

		// p(d|z), size: K x M
		double[][] Pd_z = new double[this.K][this.M];

		// p(w|z), size: K x V
		double[][] Pw_z = new double[this.K][this.V];

		// p(z|d,w), size: K x M x doc.size()
		double[][][] Pz_dw = new double[this.K][this.M][];

		// L: log-likelihood value
		double L = -1;

		// run EM algorithm
		this.init(Pz, Pd_z, Pw_z, Pz_dw);
		for (int it = 0; it < iters; it++)
		{
			// E-step
			if (!this.Estep(Pz, Pd_z, Pw_z, Pz_dw))
			{
				ErrorReport.showMessage(this, "EM", "in E-step");
			}

			// M-step
			if (!this.Mstep(Pz_dw, Pw_z, Pd_z, Pz))
			{
				ErrorReport.showMessage(this, "EM", "in M-step");
			}

			L = calcLoglikelihood();
		}

		return false;
	}

	private boolean init(double[] Pz, double[][] Pd_z, double[][] Pw_z,
			double[][][] Pz_dw)
	{
		// p(z), size: K
		double zvalue = (double) 1 / (double) this.K;
		for (int z = 0; z < this.K; z++)
		{
			Pz[z] = zvalue;
		}

		// p(d|z), size: K x M
		for (int z = 0; z < this.K; z++)
		{
			double norm = 0.0;
			for (int m = 0; m < this.M; m++)
			{
				Pd_z[z][m] = Math.random();
				norm += Pd_z[z][m];
			}

			for (int m = 0; m < this.M; m++)
			{
				Pd_z[z][m] /= norm;
			}
		}

		// p(w|z), size: K x V
		for (int z = 0; z < this.K; z++)
		{
			double norm = 0.0;
			for (int w = 0; w < this.V; w++)
			{
				Pw_z[z][w] = Math.random();
				norm += Pw_z[z][w];
			}

			for (int w = 0; w < this.V; w++)
			{
				Pw_z[z][w] /= norm;
			}
		}

		// p(z|d,w), size: K x M x doc.size()
		for (int z = 0; z < this.K; z++)
		{
			for (int m = 0; m < this.M; m++)
			{
				Pz_dw[z][m] = new double[this.dataset.getAt(m).size()];
			}
		}

		return false;
	}

	private boolean Estep(double[] Pz, double[][] Pd_z, double[][] Pw_z,
			double[][][] Pz_dw)
	{
		for (int m = 0; m < this.M; m++)
		{
			Data data = this.dataset.getAt(m);
			for (int i = 0; i < data.size(); i++)
			{
				// get word(dimension) at position i of document m
				int w = data.getFeatureAt(i).dim;

				double norm = 0.0;
				for (int z = 0; z < this.K; z++)
				{
					Pz_dw[z][m][w] = Pz[z] * Pd_z[z][m] * Pw_z[z][w];
					norm += Pz_dw[z][m][w];
				}

				for (int z = 0; z < this.K; z++)
				{
					Pz_dw[z][m][w] /= norm;
				}
			}
		}

		return true;
	}

	private boolean Mstep(double[][][] Pz_dw, double[][] Pw_z, double[][] Pd_z,
			double[] Pz)
	{
		// p(w|z)
		
		// p(d|z)
		
		//p(z)

		return true;
	}

	private double calcLoglikelihood()
	{
		return -1;
	}
}
