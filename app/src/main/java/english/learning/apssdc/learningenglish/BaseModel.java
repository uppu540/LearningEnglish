package english.learning.apssdc.learningenglish;

import java.io.Serializable;

public class BaseModel implements Serializable
{
	@Override
	public String toString()
	{
		return JsonUtils.toString(this);
	}
}
