package DB;

import APP.Music;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MusicDAO {

    public List<Music> list() {
        try {

            Connection c = Connect.connect();

            List<Music> res = new ArrayList<Music>();

            if (c != null) {
                PreparedStatement psMusic = c.prepareStatement("SELECT M.idMusic, M.Album, M.Author, M.Nome, M.Genre, M.Owner FROM Music AS M;");
                ResultSet rsMusic = psMusic.executeQuery();

                while (rsMusic.next()) {
                    Music m = new Music(rsMusic.getInt("idMusic"), rsMusic.getString("Nome"), rsMusic.getString("Album"), rsMusic.getString("Author"), rsMusic.getString("Genre"));

                    res.add(m);
                }

                c.close();

                return res;
            }

        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());

        }

        return null;
    }

    public Music get(Integer idMusic) {
        try {

            Connection c = Connect.connect();

            if (c != null) {

                PreparedStatement psMusic = c.prepareStatement("SELECT M.idMusic FROM Music AS M WHERE M.idMusic=?;");
                psMusic.setInt(1, idMusic);
                ResultSet rsMusic = psMusic.executeQuery();

                if (rsMusic.next()) {
                    Music m = new Music(idMusic, rsMusic.getString("Nome"), rsMusic.getString("Album"), rsMusic.getString("Author"), rsMusic.getString("Genre"));

                }

                c.close();
            }
        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }

        return null;
    }

    public boolean containsKey(String email) {

        try {
            Connection c = Connect.connect();
            if (c != null) {
                PreparedStatement ps = c.prepareStatement("SELECT Email FROM `User` WHERE `Email`=?;");
                ps.setString(1, email);
                ResultSet rs = ps.executeQuery();
                return rs.next();
            }
        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());

        }

        return false;
    }

    public void put(Music m) {
        try {
            Connection c = Connect.connect();
            assert c != null;
            PreparedStatement ps = c.prepareStatement("INSERT INTO Music (Email, Password, Username) VALUES (?,?,?);");
            ps.setInt(1, m.getId());
            ps.setString(2, m.getAlbum());
            ps.setString(3, m.getAutor());
            ps.setString(4, m.getName());
            ps.setString(5, m.getGenero());
            ps.executeUpdate();

            c.close();

        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());

        }
    }
}

