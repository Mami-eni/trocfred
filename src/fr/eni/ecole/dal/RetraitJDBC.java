package fr.eni.ecole.dal;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import fr.eni.ecole.bo.Article;
import fr.eni.ecole.bo.Retrait;


public class RetraitJDBC implements RetraitDAO {

	public void insert(Retrait r) {
		try(Connection cx = Connect.getConnection()){
			PreparedStatement request = cx.prepareStatement("INSERT INTO retraits (no_article, rue, code_postal, ville)"
					+ " VALUES(?,?,?,?)");
			request.setInt(1, r.getArticle().getNumero());
			request.setString(2, r.getRue());
			request.setString(3, r.getCodePostal());
			request.setString(4, r.getVille());
			request.executeUpdate();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public Retrait selectByArticle(Article a) {
		Retrait ret = new Retrait();
		try(Connection cx = Connect.getConnection()){
			PreparedStatement request = cx.prepareStatement("SELECT rue, code_postal, ville WHERE no_article = ?");
			request.setInt(1, a.getNumero());
			ResultSet rs = request.executeQuery();
			ret.setArticle(a);
			ret.setRue(rs.getString("rue"));
			ret.setCodePostal(rs.getString("code_postal"));
			ret.setVille(rs.getString("ville"));
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return ret;
	}

	@Override
	public List<Retrait> selectAll() {
		throw new UnsupportedOperationException("Not supported yet.");	
	}

	@Override
	public Retrait selectById(int id) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public void update(Retrait item) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public void delete(Retrait item) {
		throw new UnsupportedOperationException("Not supported yet.");
	}
	
}
