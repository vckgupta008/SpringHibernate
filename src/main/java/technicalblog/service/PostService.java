package technicalblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import technicalblog.model.Post;
import technicalblog.repository.PostRepository;


import java.sql.*;
import java.util.*;
import java.util.Date;

@Service
public class PostService {


    public PostService(){
        System.out.println("*** PostService ***");
    }

    @Autowired
    private PostRepository repository;
//    @PersistenceUnit(unitName = "techblog")
//    private EntityManagerFactory emf;

    public List<Post> getAllPost(){

         return repository.getAllPosts();

//        EntityManager em = emf.createEntityManager();
//        TypedQuery<Post> query = em.createQuery("SELECT p from Post p", Post.class);
//        List<Post> resultList = query.getResultList();
//        List<Post> resultList = new ArrayList<>();
//        return resultList;

//        ArrayList<Post> posts=new ArrayList<>();
//        Connection connection=null;
//        try {
//            Class.forName("org.postgresql.Driver");//jdbc driver class for postgres
//             connection = DriverManager
//                    .getConnection("jdbc:postgresql://localhost:5432/technicalBlogApplication",
//                            "postgres", "postgres");
//            Statement statement = connection.createStatement();
//            ResultSet rs = statement.executeQuery("SELECT * FROM posts");
//            while(rs.next()){
//                Post post = new Post();
//                post.setTitle(rs.getString("title"));
//                post.setBody(rs.getString("body"));
//                posts.add(post);
//            }
//        }
//        catch(Exception e){
//            System.out.print("Error in fetching record from database");
//        }
//        finally{
//            try{
//                connection.close();
//            }catch(SQLException e){
//                e.printStackTrace();
//            }
//        }
//        return posts;
//
//        Post post = new Post();
//        post.setTitle("Post 1");
//        post.setBody("POst bodt 1");
//        post.setDate(new Date());
//
//        Post post2 = new Post();
//        post2.setTitle("Post 2");
//        post2.setBody("POst bodt 2");
//        post2.setDate(new Date());
//
//        Post post3 = new Post();
//        post3.setTitle("Post 3");
//        post3.setBody("POst bodt 3");
//        post3.setDate(new Date());
//
//        posts.add(post);
//        posts.add(post2);
//        posts.add(post3);
//        return posts;
    }

    public void createPost (Post newPost){
        newPost.setDate(new Date());
        repository.createPost(newPost);
        System.out.println("New post is created");
    }

    public ArrayList<Post> getOnePost(){
//        return repository.getLatestPost();
        ArrayList<Post> posts=new ArrayList<>();
        Connection connection=null;
        try {
            Class.forName("org.postgresql.Driver");//jdbc driver class for postgres
           connection = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/technicalBlogApplication",
                            "postgres", "postgres");
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM posts where id = 3");
            while(rs.next()){
                Post post = new Post();
                post.setTitle(rs.getString("title"));
                post.setBody(rs.getString("body"));
                posts.add(post);
            }
        }
        catch(Exception e){
            System.out.print("Error in fetching record from database");
        }
        finally{
            try{
                connection.close();
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
        return posts;
    }

    public Post getPost(Integer postId) {
        return repository.getPost(postId);
    }

    public void updatePost(Post updatedPost) {
        updatedPost.setDate(new Date());
        repository.updatePost(updatedPost);
    }

    public void deletePost(Integer postId) {
        repository.deletePost(postId);
    }
}
