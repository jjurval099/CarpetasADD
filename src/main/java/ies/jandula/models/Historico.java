package ies.jandula.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Historico
{
	private Date date;
	
	private List<Integer> numbers;
	
	private int complement;
	
	private int refund;
	
	public Historico()
	{
		this.date = new Date();
		this.numbers = new ArrayList<Integer>();
		
	}

	public Historico(Date date, List<Integer> numbers, int complement, int refund)
	{
		this.date = date;
		this.numbers = numbers;
		this.complement = complement;
		this.refund = refund;
	}

	public Date getDate()
	{
		return this.date;
	}

	public void setDate(Date date)
	{
		this.date = date;
	}

	public List<Integer> getNumbers()
	{
		return this.numbers;
	}
	
	public void setNumbers(List<Integer> numbers)
	{
		this.numbers = numbers;
	}

	public int getComplement()
	{
		return this.complement;
	}

	public void setComplement(int complement)
	{
		this.complement = complement;
	}

	public int getRefund()
	{
		return this.refund;
	}

	public void setRefund(int refund)
	{
		this.refund = refund;
	}

	@Override
	public String toString() 
	{
		StringBuilder builder = new StringBuilder();
		builder.append("Historico [date=");
		builder.append(date);
		builder.append(", numbers=");
		builder.append(numbers);
		builder.append(", complement=");
		builder.append(complement);
		builder.append(", refund=");
		builder.append(refund);
		builder.append("]");
		return builder.toString();
	}

	
}
