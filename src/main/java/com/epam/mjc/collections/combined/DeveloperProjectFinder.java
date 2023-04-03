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
        var comparisonResult = Integer.compare(this.getProject().length(), other.getProject().length());
        comparisonResult = comparisonResult == 0 ? this.getProject().compareTo(other.getProject()) : comparisonResult;
        return comparisonResult;
    }

    @Override
    public boolean equals(Object other) {
        return Objects.nonNull(other) && other instanceof ProjectRecord && project.equals(((ProjectRecord) other).project);
    }
}

public class DeveloperProjectFinder {


    public List<String> findDeveloperProject(Map<String, Set<String>> projects, String developer) {
        var projectRecords = new ArrayList<ProjectRecord>();

        for (var entry : projects.entrySet()) {
            var project = entry.getKey();
            if (projects.get(project).contains(developer)) {
                projectRecords.add(new ProjectRecord(project));
            }
        }

        projectRecords.sort(Comparator.reverseOrder());

        var foundProjects = new ArrayList<String>();
        for (var record : projectRecords) {
            foundProjects.add(record.getProject());
        }

        return foundProjects;
    }
}
