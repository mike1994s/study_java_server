package dbService.dao;

import dbService.dataSets.UsersDataSet;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 * Created by misha on 07.12.16.
 */
public class UsersDAO {
    private Session session;

    public UsersDAO(Session session) {
        this.session = session;
    }

    public UsersDataSet get(long id) throws HibernateException {
        return (UsersDataSet) session.get(UsersDataSet.class, id);
    }

    public long getUserId(String login) throws HibernateException {
        Criteria criteria = session.createCriteria(UsersDataSet.class);
        return ((UsersDataSet) criteria.add(Restrictions.eq("login", login)).uniqueResult()).getId();
    }
    public UsersDataSet getUserData(String login) throws HibernateException {
        Criteria criteria = session.createCriteria(UsersDataSet.class);
        return ((UsersDataSet) criteria.add(Restrictions.eq("login", login)).uniqueResult());
    }

    public long insertUser(String login, String email, String pass) throws HibernateException {
        return (Long) session.save(new UsersDataSet(login, email, pass));
    }
}
