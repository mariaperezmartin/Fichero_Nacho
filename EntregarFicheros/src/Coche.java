import java.io.Serializable;

public class Coche implements Serializable{
	private String matricula;
	private int anioMatriculacion;
	
	public Coche() {
	}
	
	public Coche(String matricula, int anioMatriculacion) {
		this.matricula = matricula;
		this.anioMatriculacion = anioMatriculacion;
	}
	
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public int getAnioMatriculacion() {
		return anioMatriculacion;
	}
	public void setAnioMatriculacion(int anioMatriculacion) {
		this.anioMatriculacion = anioMatriculacion;
	}

	@Override
	public String toString() {
		return "Coche [matricula=" + matricula + ", anioMatriculacion=" + anioMatriculacion + "]";
	}
	
	
	
}
