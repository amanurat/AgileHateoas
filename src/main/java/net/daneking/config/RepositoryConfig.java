package net.daneking.config;

import java.util.ArrayList;
import java.util.List;

import net.daneking.agile.iteration.Iteration;
import net.daneking.agile.iteration.IterationRepository;
import net.daneking.agile.story.Story;
import net.daneking.agile.story.StoryRepository;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RepositoryConfig {
	@Bean
	public IterationRepository iterationRepository() {
		return new IterationRepository() {
			@Override
			public Iteration findIterationBy(final Integer id) {
				return new Iteration(id + 2);
			}

		};
	}

	@Bean
	public StoryRepository storyRepository() {
		return new StoryRepository() {

			@Override
			public Story findById(final Integer iterationId) {
				return new Story(iterationId + 2);
			}

			@Override
			public List<Story> findStoriesBy(final Integer iteration) {
				List<Story> stories = new ArrayList<Story>();
				stories.add(new Story(4));
				stories.add(new Story(7));
				return stories;
			}
		};
	}
}
