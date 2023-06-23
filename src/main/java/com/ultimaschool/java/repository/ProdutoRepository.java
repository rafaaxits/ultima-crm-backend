package com.ultimaschool.java.repository;

import com.ultimaschool.java.model.Produto;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoRepository {

    private DatabaseConnection connection;

    public ProdutoRepository() {
        this.connection = DatabaseConnection.getInstance();
    }

    public List<Produto> findAll() throws SQLException {
        List<Produto> produtos = new ArrayList<>();

        PreparedStatement preparedStatement = this.connection
                .getConnection()
                .prepareStatement("select * from crm_db.produto;");
        ResultSet resultSet = preparedStatement.executeQuery();

        while(resultSet.next()) {
            Produto produto = new Produto();
            produto.setId(resultSet.getInt("id"));
            produto.setNome(resultSet.getString("nome"));
            produto.setPreco(resultSet.getDouble("preco"));
            produtos.add(produto);
        }
        return produtos;
    }

    public Produto findById(int id) throws SQLException {
        Produto produto = null;

        PreparedStatement preparedStatement = this.connection
                .getConnection()
                .prepareStatement("select * from crm_db.produto where id = ?;");
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();

        if(resultSet.next()) {
            produto = new Produto();
            produto.setId(resultSet.getInt("id"));
            produto.setNome(resultSet.getString("nome"));
            produto.setPreco(resultSet.getDouble("preco"));
        }
        return produto;
    }

    public boolean insert (Produto produto) throws SQLException {
        boolean inserted = false;

        String insertSQL = "INSERT INTO crm_db.produto (nome, preco) VALUES(?, ?);";

        PreparedStatement preparedStatement = this.connection
                .getConnection()
                .prepareStatement(insertSQL);

        preparedStatement.setString(1, produto.getNome());
        preparedStatement.setDouble(2, produto.getPreco());

        inserted = preparedStatement.execute();

        return inserted;
    }

    public boolean update (Produto produto) throws SQLException {
        boolean updated = false;

        if(produto == null || produto.getId() <= 0){
            return updated;
        }

        String updateSQL = "UPDATE crm_db.produto " +
                "SET nome = ?, " +
                "preco = ? " +
                "WHERE id=?;";

        PreparedStatement preparedStatement = this.connection
                .getConnection()
                .prepareStatement(updateSQL);

        preparedStatement.setString(1, produto.getNome());
        preparedStatement.setDouble(2, produto.getPreco());
        preparedStatement.setInt(3, produto.getId());

        updated = preparedStatement.execute();

        return updated;
    }

    public boolean delete (int id) throws SQLException {
        boolean isDeleted = false;

        String deleteSQL = "DELETE FROM crm_db.produto WHERE id=?;";
        PreparedStatement preparedStatement = this.connection
                .getConnection()
                .prepareStatement(deleteSQL);
        preparedStatement.setInt(1, id);

        isDeleted = preparedStatement.execute();

        return isDeleted;
    }

}
