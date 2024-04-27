/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RW.forms;

/**
 *
 * @author rauls
 */


public class ModelLocation {

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVideoPath() {
        return videoPath;
    }

    public void setVideoPath(String videoPath) {
        this.videoPath = videoPath;
    }

    public ModelLocation(String title, String description, String videoPath) {
        this.title = title;
        this.description = description;
        this.videoPath = videoPath;
    }

    private String title;
    private String description;
    private String videoPath;
}

