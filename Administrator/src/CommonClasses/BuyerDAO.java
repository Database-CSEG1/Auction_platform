package CommonClasses;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BuyerDAO implements DAO<Buyer> {

    @Override
    public Buyer get(int ID) throws SQLException {
      Connection con = Database.getConnection();
        Buyer buyer = null;
        String sql = "select BuyerID ,BidID, UserID from Buyer where BuyerId = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, ID);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            int BuyerID = rs.getInt("BuyerID");
            int BidID = rs.getInt("BidID");
            int UserID = rs.getInt("UserID");
            buyer = new Buyer(BuyerID,BidID,UserID);
        }
        return buyer;
    }

    @Override
    public List<Buyer> getAll() throws SQLException {
        List<Buyer> buyers = new ArrayList<Buyer>();
        Connection con = Database.getConnection();
        String sql = "select * from Buyers";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Buyer buyer = null;
            int BuyerID = rs.getInt("BuyerID");
            int ItemID = rs.getInt("ItemID");
            int UserID = rs.getInt("UserID");
            buyer = new Buyer(BuyerID, ItemID, UserID);
            buyers.add(buyer);

        }
        return buyers;
    }

    @Override
    public int insert(Buyer t) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insert'");
    }

    @Override
    public int update(Buyer t) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public int delete(Buyer t) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }
    
}
