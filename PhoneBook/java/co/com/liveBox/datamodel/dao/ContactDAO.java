package co.com.liveBox.datamodel.dao;

import co.com.liveBox.datamodel.vo.Contact;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;
import java.util.UUID;

public class ContactDAO {
    private SqlSessionFactory sqlSessionFactory = null;
    
    public ContactDAO(SqlSessionFactory sqlSessionFactory){
        this.sqlSessionFactory = sqlSessionFactory;
    }

    /**
     * Returns the list of all Contact instances from the database.
     * @return the list of all Contact instances from the database.
     */
    public List<Contact> selectAll(){
        List<Contact> list = null;
        SqlSession session = sqlSessionFactory.openSession();

        try {
            list = session.selectList("Contact.selectAll");
        } finally {
            session.close();
        }
        System.out.println("selectAll() --> "+list);
        return list;
    }

    /**
     * Select instance of Contact from the database.
     * @param name the instance to be persisted.
     */
        public Contact selectByname(String name){
            Contact contact = null;
            SqlSession session = sqlSessionFactory.openSession();
            try {
                name = session.selectOne("Contact.selectByname", name);

            } finally {
                session.close();
            }
            System.out.println("selectByname(" + name + ") --> " + name);
            return contact;
    }

    /**
     * Insert an instance of Contact into the database.
     * @param contact the instance to be persisted.
     */
    public int insert(Contact contact){
        int rows = -1;
        contact.setId(UUID.randomUUID());
        SqlSession session = sqlSessionFactory.openSession();

        try {
            rows = session.insert("Contact.insert", contact);
        } finally {
            session.commit();
            session.close();
        }
        System.out.println("insert(" + contact + ") --> " + contact.getId());
        return rows;
    }
}
