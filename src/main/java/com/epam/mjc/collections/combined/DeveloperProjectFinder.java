package com.epam.mjc.collections.combined;

import java.util.*;

class ProjectRecord implements Comparable<ProjectRecord> {
    private final String project;

    ProjectRecord(String project) {
        this.project = project;
    }

    public String getProject() {
        return project;
    }


    @Override
    public int compareTo(ProjectRecord other) {
        return Integer.compare(this.getProject().length(), other.getProject().length());
    }
}

public class DeveloperProjectFinder {


    public List<String> findDeveloperProject(Map<String, Set<String>> projects, String developer) {
        var projectRecords = new ArrayList<ProjectRecord>();

        for (var project : projects.keySet()) {
            if (projects.get(project).contains(developer)) {
                projectRecords.add(new ProjectRecord(project));
            }
        }

        projectRecords.sort(Comparator.reverseOrder());

        var result = new ArrayList<String>();
        for (var record : projectRecords) {
            result.add(record.getProject());
        }

        return result;
    }
}
