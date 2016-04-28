package markfj81.tacoma.uw.edu.webservicelab.model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Mark on 4/27/2016.
 */
public class Course implements Serializable {
    private String mCourseID;
    private String mShortDescription;
    private String mLongDescription;
    private String mPrereqs;
    public static final String ID = "id", SHORT_DESC = "shortDesc"
            , LONG_DESC = "longDesc", PRE_REQS = "prereqs";

    public Course(final String courseID, final String shortDescription, final String longDescription,
                  final String prereqs) {
        this.mCourseID = courseID;
        this.mShortDescription = shortDescription;
        this.mLongDescription = longDescription;
        this.mPrereqs =  prereqs;
    }

//    public void setID(final String courseID) {
//        this.mCourseID = courseID;
//    }
//    public void setShortDesc(final String shortDescription) {
//        this.mShortDescription = shortDescription;
//    }
//    public void setmLongDescription(final String mLongDescription) {
//        this.mLongDescription = mLongDescription;
//    }
//    public void setPrereqs(final String mPrereqs) {
//        this.mPrereqs = mPrereqs;
//    }

    public String getCourseId() {
        return mCourseID;
    }

    public String getShortDescription() {
        return mShortDescription;
    }
    public String getLongDescription(){
        return mLongDescription;
    }
    public String getPrereqs() {
        return mPrereqs;
    }

    /**
     * Parses the json string, returns an error message if unsuccessful.
     * Returns course list if success.
     * @param courseJSON
     * @return reason or null if successful.
     */
    public static String parseCourseJSON(String courseJSON, List<Course> courseList) {
        String reason = null;
        if (courseJSON != null) {
            try {
                JSONArray arr = new JSONArray(courseJSON);

                for (int i = 0; i < arr.length(); i++) {
                    JSONObject obj = arr.getJSONObject(i);
                    Course course = new Course(obj.getString(Course.ID), obj.getString(Course.SHORT_DESC)
                            , obj.getString(Course.LONG_DESC), obj.getString(Course.PRE_REQS));
                    courseList.add(course);
                }
            } catch (JSONException e) {
                reason =  "Unable to parse data, Reason: " + e.getMessage();
            }
        }
        return reason;
    }


}
