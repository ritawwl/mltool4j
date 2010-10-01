package edu.thu.mltool4j.data;

import java.util.ArrayList;

public class Data
{
	/**
	 * Data identifier
	 */
	private String id;

	/**
	 * features array
	 */
	private ArrayList<Feature> features = null;

	/**
	 * Total element number
	 */
	private int size;

	/**
	 * Create a Data object from string line. The line format is same as that
	 * used in svmlight and libsvm, for example: "-1 1:0.43 3:0.12 9284:0.2"
	 * Please be care that the index is start from 1, and no comment part is
	 * included.
	 * 
	 * @param line
	 *            the data line in svmlight and libsvm format
	 */
	public Data(String line)
	{

	}

	/**
	 * Get the feature at the specified position.
	 * 
	 * @param position
	 * @return the feature at the specified position.
	 */
	public Feature getFeatureAt(int position)
	{
		return features.get(position);
	}

	/**
	 * Get dim of feature at the specified position.
	 * 
	 * @param position
	 * @return dim of feature at the specified position.
	 */
	public int getDimAt(int position)
	{
		return features.get(position).dim;
	}

	/**
	 * Get value of feature at the specified position.
	 * 
	 * @param position
	 * @return value of feature at the specified position.
	 */
	public double getValueAt(int position)
	{
		return features.get(position).value;
	}

	public String getID()
	{
		return this.id;
	}
}
