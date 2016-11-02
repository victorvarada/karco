package com.isidis.prototype.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.isidis.prototype.bean.Client;

public class ClientDAO extends DAO<Client> {

	@Override
	public Client find(Integer id) {
		Client client = new Client();
		try {
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)
					.executeQuery("SELECT * FROM client WHERE id_client = " + id);
			if (result.first())
				client = new Client(id, result.getString("nom_client"), result.getString("prenom_client"),
						result.getString("email_client"));

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return client;
	}

	@Override
	public Client create(Client obj) {
		try {
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)
					.executeQuery("SELECT NEXTVAL('client_lan_id_seq') as id");
			if (result.first()) {
				Integer id = result.getInt("id");
				PreparedStatement prepare = this.connect
						.prepareStatement("INSERT INTO client (id_client, nom_client, prenom_client, email_client) VALUES(?, ?, ?, ?)");
				prepare.setLong(1, id);
				prepare.setString(2, obj.getNom());
				prepare.setString(3, obj.getPrenom());
				prepare.setString(4, obj.getEmail());
				
				prepare.executeUpdate();
				obj = this.find(id);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return obj;
	}

	@Override
	public Client update(Client obj) {
		/* try {
			PreparedStatement prepare = this.connect.prepareStatement(
					"UPDATE societe SET soc_nom = '" + obj.getNom() + "'" + " WHERE soc_id = " + obj.getId());

			prepare.executeUpdate();

			// Maintenant, nous devons créer les liens vers les développeurs
			// Si le développeur n'existe pas en base, on le créé
			for (Developpeur dev : obj.getListDeveloppeur()) {

				DAO<Developpeur> developpeurDAO = AbstractDAOFactory.getFactory(FactoryType.DAO_FACTORY)
						.getDeveloppeurDAO();

				// Si l'objet n'existe pas, on le créé avec sa jointure
				if (dev.getId() == 0) {

					dev = developpeurDAO.create(dev);

					// On récupère la prochaine valeur de la séquence
					ResultSet result2 = this.connect
							.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)
							.executeQuery("SELECT NEXTVAL('j_soc_dev_jsd_id_seq') as id");
					if (result2.first()) {

						long id2 = result2.getLong("id");
						PreparedStatement prepare2 = this.connect.prepareStatement(
								"INSERT INTO j_soc_dev (jsd_id, jsd_soc_k, jsd_dev_k)" + "VALUES(?, ?, ?)");
						prepare2.setLong(1, id2);
						prepare2.setLong(2, obj.getId());
						prepare2.setLong(3, dev.getId());
						prepare2.executeUpdate();
					}

				} else {
					developpeurDAO.update(dev);
				}

			}

			obj = this.find(obj.getId());

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return obj; */
		return null;
	}

	@Override
	public void delete(Client obj) {
		try {
			this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)
					.executeUpdate("DELETE FROM client WHERE id_client = " + obj.getId());

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}