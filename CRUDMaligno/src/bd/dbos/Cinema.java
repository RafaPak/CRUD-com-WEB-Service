package bd.dbos;

public class Cinema
{
	private int cod;
	private String nome, cep, numero, complemento;
        
        public Cinema (int c, String n, String cep , String num, String cmpl) throws Exception
        {
            this.setCod(c);
            this.setNome(n);
            this.setCEP(cep);
            this.setNumero(num);
            this.setComplemento(cmpl);
        }
	
	public void setCod (int codigo) throws Exception
	{
		if (codigo < 0)
                    throw new Exception("Código inv�lido!");
		
		this.cod = codigo;
	}
	
	public int getCod()
	{
		return this.cod;
	}
	
	public void setNome(String n) throws Exception
	{
		if (n == null)
                    throw new Exception("Nome inválido!");
		
		this.nome = n;
	}
	
	public String getNome()
	{
		return this.nome;
	}
	
	public void setCEP(String c) throws Exception
	{
		if (c == null)
                    throw new Exception("CEP inválido!");
		
		this.cep = c;
	}
	
	public String getCEP()
	{
		return this.cep;
	}
	
	public void setNumero(String nmr) throws Exception
	{
		this.numero = nmr;
	}
	
	public String getNumero()
	{
		if (this.numero == null)
                    return "";
		
		return this.numero;
	}
	
	public void setComplemento(String cmp) throws Exception
	{	
		this.complemento = cmp;
	}
	
	public String getComplemento()
	{
		if (this.complemento == null)
			return "";
			
		return this.complemento;
	}
	
	public String toString()
	{
		return "Código:      " + this.cod      + "\n" +
                       "Nome:        " + this.nome     + "\n" +
                       "CEP:         " + this.cep      + "\n" +
                       "Número:      " + this.numero   + "\n" +
                       "Complemento: " + this.complemento;
 	}
	
	public boolean equals(Object obj)
	{
		if (this == obj)
            return true;

        if (obj == null)
            return false;

        if (!(obj instanceof Cinema))
            return false;
        
        Cinema c = (Cinema)obj;
        
        if (this.cod != c.cod)
        	return false;
        
        if (!this.nome.equals(c.nome))
        	return false;
        
        if (!this.cep.equals(c.cep))
        	return false;
        
        if (!this.numero.equals(c.numero))
        	return false;
        
        if (!this.complemento.equals(c.complemento))
        	return false;
        
        return true;
	}
	
	public int hashCode()
	{
		int ret = 7;
		
		ret *= 2 + new Integer(this.cod).hashCode();
		ret *= 2 + this.nome.hashCode();
		ret *= 2 + this.cep.hashCode();
		ret *= 2 + this.numero.hashCode();
		ret *= 2 + this.complemento.hashCode();
		
		return ret;
	}
	
	public Cinema (Cinema m) throws Exception
	{
		this.cod = m.cod;
		this.nome = m.nome;
		this.cep = m.cep;
		this.numero = m.numero;
		this.complemento = m.complemento;
	}
	
	public Object clone()
        {
            Cinema ret = null;

            try
            {
                ret = new Cinema(this);
            }
            catch (Exception erro)
            {}

            return ret;
        }
}