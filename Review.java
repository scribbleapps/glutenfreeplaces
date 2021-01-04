package uk.co.scribbleapps.glutenfreeplaces;

import android.util.Log;

import androidx.annotation.NonNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

public class Review {
    private static final String TAG = "Review";

    private String date;
    private String eateryAddress;
    private String eateryName;
    private String placeID;
    private String rating;
    private String review;
    private String userEmail;
    private String userName;

    public Review() {
    }

    // Getters
    public String getPlaceID() {
        return placeID;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getReview() {
        return review;
    }

    public String getDate() {
        return date;
    }

    public String getEateryName() {
        return eateryName;
    }

    public String getEateryAddress() {
        return eateryAddress;
    }

    public String getRating() {
        return rating;
    }

    // Setters
    public void setPlaceID(String placeID) {
        this.placeID = placeID;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public void setReview(String review) {
        this.review = review;
    }


    public void setDate(String date) {
        this.date = date;
    }

    public void setEateryName(String eateryName) {
        this.eateryName = eateryName;
    }

    public void setEateryAddress(String eateryAddress) {
        this.eateryAddress = eateryAddress;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    @Override
    @NonNull
    public String toString() {
        return "Review{" +
                "placeID='" + placeID + '\'' +
                ", userName='" + userName + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", review='" + review + '\'' +
                ", date='" + date + '\'' +
                ", eateryName='" + eateryName + '\'' +
                ", eateryAddress='" + eateryAddress + '\'' +
                ", rating='" + rating + '\'' +
                '}';
    }

    // Comparator for sorting Reviews by Date (newest first)
    public static Comparator<Review> DateAddedComparator = new Comparator<Review>() {
        @Override
        public int compare(Review r1, Review r2) {

            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

            Date dt1 = new Date();
            try {
                dt1 = formatter.parse(r1.getDate());
            } catch (ParseException e) {
                Log.e(TAG, "compare: dt1 excpetion: " + e.getMessage());
                return 0;
            }
            Date dt2 = new Date();
            try {
                dt2 = formatter.parse(r2.getDate());
            } catch (ParseException e) {
                Log.e(TAG, "compare: dt2 excpetion: " + e.getMessage());
                return 0;
            }

            // There should always be a date. Null check just in case.
            if (null == dt1) {
                return 1;
            }
            if (null == dt2) {
                return -1;
            }

            boolean check = dt1.after(dt2);
            if (check) {
                return -1;
            } else {
                return 1;
            }
        }
    };

    // Comparator for sorting Reviews by Name A to Z
    public static Comparator<Review> PlaceNameAtoZComparator = new Comparator<Review>() {
        @Override
        public int compare(Review r1, Review r2) {

            String review1Name = "";
            String review2Name = "";

            try {
                review1Name = r1.getEateryName();
                review2Name = r2.getEateryName();
            } catch (Exception e) {
                Log.e(TAG, "Name comparator error: " + e.getMessage());
            }

            return review1Name.compareToIgnoreCase(review2Name);
        }
    };

    // Comparator for sorting Reviews by Name Z to A
    public static Comparator<Review> PlaceNameZtoAComparator = new Comparator<Review>() {
        @Override
        public int compare(Review r1, Review r2) {

            String review1Name = "";
            String review2Name = "";

            try {
                review1Name = r1.getEateryName();
                review2Name = r2.getEateryName();
            } catch (Exception e) {
                Log.e(TAG, "Name comparator error: " + e.getMessage());
            }

            return review2Name.compareToIgnoreCase(review1Name);
        }
    };
}
