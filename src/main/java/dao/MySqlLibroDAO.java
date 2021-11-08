package dao;

import java.util.List;

import beans.Libro;
import interfaces.LibroInterface;

public class MySqlLibroDAO implements LibroInterface{

	@Override
	public List<Libro> getListLibro() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int createLibro(Libro pa) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Libro getLibro(String cod) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int editLibro(Libro pa) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int removeLibro(String cod) {
		// TODO Auto-generated method stub
		return 0;
	}

}
