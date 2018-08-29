package beans;

import java.util.Date;

public interface IPublication {
	public String getAuteur();
	public Date getDate();
	public String getContenu();
	public ICategorie getCategorie();
}
