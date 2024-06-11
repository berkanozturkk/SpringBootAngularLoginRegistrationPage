package securedlogin.service;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import securedlogin.repo.UserRepo;


import org.springframework.stereotype.Service;

@Service
public class ReviewService {


    public List<String> getFilmReviews(String filmName) {
        List<String> reviews = new ArrayList<>();
        System.out.println("Girdi");
        try {
            String rtUrl = "https://www.rottentomatoes.com/m/" + filmName + "/reviews?type=top_critics";
            Document rtDocument = Jsoup.connect(rtUrl).get();
            Elements rtReviews = rtDocument.select(".review-text");
            rtReviews.forEach(review -> reviews.add(review.text()));
            reviews.add("");
            reviews.add("----------Letterboxd Reviews :");
            reviews.add("");
            String lboxdUrl = "https://letterboxd.com/film/" + filmName + "/reviews/by/activity/";
            Document lboxdDocument = Jsoup.connect(lboxdUrl).ignoreHttpErrors(true).get();
            Elements lboxdReviews = lboxdDocument.select(".body-text.-prose.collapsible-text");
            lboxdReviews.forEach(review -> reviews.add(review.text()));


        } catch (IOException e) {
            e.printStackTrace();
        }

        return reviews;
    }
}