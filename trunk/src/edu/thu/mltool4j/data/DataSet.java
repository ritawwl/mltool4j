package edu.thu.mltool4j.data;

import java.util.ArrayList;

public class DataSet
{
	private ArrayList<Data> datas;

	public DataSet()
	{
		this.datas = new ArrayList<Data>();
	}

	public DataSet(ArrayList<Data> initDatas)
	{
		this.datas = initDatas;
	}

	public boolean add(Data data)
	{
		return datas.add(data);
	}

	public Data getData(String dataId)
	{
		for (Data data : datas)
		{
			if (data.getID().equals(dataId))
				return data;
		}
		return null;
	}

	public Data getAt(int index)
	{
		return datas.get(index);
	}

	public ArrayList<Data> getAllData()
	{
		return datas;
	}
}
