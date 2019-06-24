package co.com.liveBox.datamodel.dao;

import co.com.liveBox.datamodel.vo.Contact;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

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
            List<String> formattedKeyWords = keyWords.stream().map(item -> "%" + item + "%").collect(Collectors.toList());
            try {
                list = session.selectList("Contact.findContact", formattedKeyWords);

            } finally {
                session.close();
            }
            return list;
    }

    /**
     * Insert an instance of Contact into the database.
     * @param contact the instance to be persisted.
     */
    public int addContact(Contact contact) throws Exception{
        int rows = -1;
        contact.setId(UUID.randomUUID());
        SqlSession session = sqlSessionFactory.openSession();

        try {
            Contact duplicated = session.selectOne("Contact.findSpecific", contact);
            if (duplicated != null){
                throw new Exception("The contact already exists");
            }
            rows = session.insert("Contact.addContact", contact);
        } finally {
            session.commit();
            session.close();
        }
        return rows;
    }
}
