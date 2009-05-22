package java.io;

public class StringWriter extends Writer
{
	//MISSING StringBuffer getBuffer()
	
	private final StringBuilder sb;
	
	public StringWriter()
	{
		this.sb = new StringBuilder();
	}
	
	public StringWriter(int size)
	{
		this.sb = new StringBuilder(size);
	}
	
	@Override
	public void close() throws IOException
	{
		//nothing
	}

	@Override
	public void flush() throws IOException
	{
		//nothing
	}
	
	@Override
	public String toString()
	{
		return this.sb.toString();
	}

	@Override
	public Writer append(CharSequence str, int start, int end) throws IOException
	{
		this.sb.append(str, start, end);
		return this;
	}

	@Override
	public void write(int c) throws IOException
	{
		this.sb.append((char)c);
	}

	@Override
	public void write(char[] c, int off, int len) throws IOException
	{		
		this.sb.append(c, off, len);
	}

	@Override
	public void write(String str, int off, int len) throws IOException
	{
		this.sb.append(str, off, off + len);
	}

	
}
