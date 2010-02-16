package edu.thu.mltool4j.data;

public class DataItem
{
	private String id;
	private int[] dims;
	private double[] values;
	private int dimNum;

	public DataItem(String initId, int[] initDims, double[] initValues)
	{
		this.id = initId;
		if (dims.length == values.length)
		{
			this.dims = initDims;
			this.values = initValues;
			this.dimNum = dims.length;
		}
	}

	public double getValueAt(int dim)
	{
		if (dim > values.length)
			return -1;
		else
			return values[dim];
	}

	public String getID()
	{
		return this.id;
	}

	public int[] getDims()
	{
		return this.dims;
	}

	public double[] getValues()
	{
		return this.values;
	}

	public int getDimNum()
	{
		return this.dimNum;
	}
}
