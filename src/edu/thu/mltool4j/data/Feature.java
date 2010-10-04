package edu.thu.mltool4j.data;

public class Feature
{
	public int dim; // starts from 0
	public double value;

	public Feature(int initDim, double initValue)
	{
		dim = initDim;
		value = initValue;
	}
}
