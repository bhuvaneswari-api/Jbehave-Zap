package com.zap.md;

import static org.jbehave.core.io.CodeLocations.codeLocationFromClass;
import static org.jbehave.core.reporters.Format.CONSOLE;
import static org.jbehave.core.reporters.Format.HTML;
import static org.jbehave.core.reporters.Format.TXT;
import static org.jbehave.core.reporters.Format.XML;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import java.util.Properties;

import com.zap.md.steps.*;
import org.jbehave.core.Embeddable;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.Keywords;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.i18n.LocalizedKeywords;
import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.model.ExamplesTableFactory;
import org.jbehave.core.model.TableTransformers;
import org.jbehave.core.parsers.RegexStoryParser;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.*;
import org.jbehave.core.steps.ParameterConverters.DateConverter;
import org.jbehave.core.steps.ParameterConverters.ExamplesTableConverter;
import org.openqa.selenium.WebDriver;


public class MyStories extends JUnitStories {

    public MyStories() {
        //Default configuration to run testcases
        configuredEmbedder().embedderControls().doGenerateViewAfterStories(true).doIgnoreFailureInStories(true)
                .doIgnoreFailureInView(true).useThreads(1).useStoryTimeoutInSecs(60);
    }

    @Override
    public Configuration configuration() {
        Class<? extends Embeddable> embeddableClass = this.getClass();

        Keywords keywords = new LocalizedKeywords(locale());


        // Start from default ParameterConverters instance
        ParameterConverters parameterConverters = new ParameterConverters();
        ParameterControls parameterControls = new ParameterControls();
        TableTransformers tableTransformers = new TableTransformers();
        // factory to allow parameter conversion and loading from external resources (used by StoryParser too)
        ExamplesTableFactory examplesTableFactory = new ExamplesTableFactory(keywords, new LoadFromClasspath(embeddableClass), parameterConverters, parameterControls, tableTransformers);
        // add custom converters
        parameterConverters.addConverters(new DateConverter(new SimpleDateFormat("yyyy-MM-dd")),
                new ExamplesTableConverter(examplesTableFactory));

        // This is to generate report under folder target/jbehave/**ur_folder_structure_story_name.html
        Properties resources = new Properties();
        resources.put("decorateNonHtml", "true");
        return new MostUsefulConfiguration()
                .useKeywords(keywords)
                .useStoryLoader(new LoadFromClasspath(embeddableClass))
                .useStoryParser(new RegexStoryParser(keywords, examplesTableFactory))
                .useStoryReporterBuilder(new StoryReporterBuilder()
                        .withCodeLocation(CodeLocations.codeLocationFromClass(embeddableClass))
                        .withDefaultFormats()
                        .withFormats(CONSOLE, TXT, HTML, XML)
                        .withKeywords(keywords)
                        .withViewResources(resources )
                )
                .useParameterConverters(parameterConverters);

    }

    private Locale locale() {
        return new Locale("en");
    }

    // Initialize all the StepsClasses here
    @Override
    public InjectableStepsFactory stepsFactory() {
        return new InstanceStepsFactory(configuration(),new CommonSteps(), new ZapHomePageSteps(),
                new ZapSearchPageSteps(), new ZapProductDetailsPageSteps(), new ZapCartPageSteps());
    }

    // Provide The testcase name - that is story file name in the below method to run it
    @Override
    protected List<String> storyPaths() {
        return new StoryFinder().findPaths(codeLocationFromClass(this.getClass()),
                "**/Story_Zap_LaunchHomePageandVerifyDetails.story",
                "");

    }


}
