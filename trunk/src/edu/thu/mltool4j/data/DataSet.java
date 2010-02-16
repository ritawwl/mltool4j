package edu.thu.mltool4j.data;

import java.util.ArrayList;

public class DataSet
{
	private ArrayList<DataItem> items;

	public DataSet()
	{
		items = new ArrayList<DataItem>();
	}

	public DataSet(ArrayList<DataItem> initItems)
	{
		this.items = initItems;
	}

	public boolean addItem(DataItem item)
	{
		return items.add(item);
	}

	public DataItem getItem(String dataItemId)
	{
		for (DataItem item : items)
		{
			if (item.getID().equals(dataItemId))
				return item;
		}
		return null;
	}

	public DataItem getItemAt(int index)
	{
		return items.get(index);
	}

	public ArrayList<DataItem> getAllDataItem()
	{
		return items;
	}
}
