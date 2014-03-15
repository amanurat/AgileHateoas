package net.daneking.agile.story;

import java.util.List;

public interface StoryRepository {

	Story findById(Integer id);

	List<Story> findStoriesBy(Integer iteration);

}
