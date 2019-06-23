package co.com.liveBox.datamodel.dao;

import co.com.liveBox.datamodel.vo.Contact;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;
import java.util.UUID;

public class ContactDAO {
    private SqlSessionFactory sqlSessionFactory;
    
    public ContactDAO(SqlSessionFactory sqlSessionFactory){
        this.sqlSessionFactory = sqlSessionFactory;
    }

    /**
     * Returns the list of all Contact instances from the database.
     * @return the list of all Contact instances from the database.
     */
    public List<Contact> selectAll(){
        List<Contact> list;
        SqlSession session = sqlSessionFactory.openSession();

        try {
            list = session.selectList("Contact.selectAll");
        } finally {
            session.close();
        }
        return list;
    }

    /**
     * Select instance of Contact from the database.
     * @param keyWords the instance to be persisted.
     */
        public List<Contact> findContact(List<String> keyWords){
            List<Contact> list;
            SqlSession session = sqlSessionFactory.openSession();
            try {
                list = session.selectList("Contact.findContact", keyWords);

            } finally {
                session.close();
            }
            return list;
    }

    /**
     * Insert an instance of Contact into the database.
     * @param contact the instance to be persisted.
     */
    public int addContact(Contact contact){
        int rows = -1;
        contact.setId(UUID.randomUUID());
        SqlSession session = sqlSessionFactory.openSession();

        try {
            rows = session.insert("Contact.addContact", contact);
        } finally {
            session.commit();
            session.close();
        }
        return rows;
    }
}
