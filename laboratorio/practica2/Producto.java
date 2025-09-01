
package laboratorio.practica2;

import java.util.Comparator;

public class Producto implements Comparable<Producto>
{
    private String nombre;
    private double precio;
    
    public Producto(String nombre,double precio)
    {
        this.nombre = nombre;
        this.precio = precio;
    }
    
    public String getNombre()
    {
        return nombre;
    }
    public double getPrecio()
    {
        return precio;
    }
    @Override
    public String toString()
    {
        return "["+nombre+","+Double.toString(precio)+"]";
    }    
    @Override
    public boolean equals(Object obj)
    {
        //SI ES LA MISMA REFERENCIA/OBJETO
		if (this == obj)
			return true;
		//SI EL OBJETO RECIBIDO ES DEL MISMO TIPO DE CLASE
		if (obj == null || getClass() != obj.getClass()) 
			return false;
		//CASTEAR AL TIPO DE CLASE Y COMPARAR ATRIBUTOS
		//NO NECESARIAMENTE SE REQUIERE COMPARAR TODOS
		Producto otro = (Producto) obj; 
		if( nombre!=null && nombre.equals( otro.getNombre() ) )
            return true;
		return false;
    }    
	@Override
	public int compareTo(Producto otro)
	{
		int result = nombre.compareToIgnoreCase( otro.getNombre() ) ;
		if(result == 0)
			return Double.compare( getPrecio() , otro.getPrecio() );
		return result;
		
	}

	public static Comparator<Producto> COMPARAR_NOMBRE()
	{
		return new Comparator<Producto>(){
			@Override
			public int compare(Producto p1, Producto p2) 
			{
				return p1.compareTo(p2);
			}
		};
	}
	public static Comparator<Producto> COMPARAR_PRECIO()
	{
		return new Comparator<Producto>(){
			@Override
			public int compare(Producto p1, Producto p2) {				
				int result = Double.compare( p1.getPrecio() , p2.getPrecio() );
				if(result == 0)
					return p1.compareTo(p2);
				return result;
			}
		};  
	}  
}