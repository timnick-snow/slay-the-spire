package com.example.shell.command;

import org.springframework.shell.component.SingleItemSelector;
import org.springframework.shell.component.StringInput;
import org.springframework.shell.component.flow.ComponentFlow;
import org.springframework.shell.component.flow.SelectItem;
import org.springframework.shell.component.support.SelectorItem;
import org.springframework.shell.standard.AbstractShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.util.*;

/**
 * @author snow
 * @since 2023/12/7
 */
public class MyCommand extends AbstractShellComponent {
    private ComponentFlow.Builder componentFlowBuilder;

    @ShellMethod(key = "flow showcase1", value = "Showcase", group = "Flow")
    public void showcase1() {
        Map<String, String> single1SelectItems = new HashMap<>();
        single1SelectItems.put("key1", "value1");
        single1SelectItems.put("key2", "value2");
        List<SelectItem> multi1SelectItems = Arrays.asList(SelectItem.of("key1", "value1"),
                SelectItem.of("key2", "value2"), SelectItem.of("key3", "value3"));
        ComponentFlow flow = componentFlowBuilder.clone().reset()
                .withStringInput("field1")
                .name("Field1")
                .defaultValue("defaultField1Value")
                .and()
                .withStringInput("field2")
                .name("Field2")
                .and()
                .withConfirmationInput("confirmation1")
                .name("Confirmation1")
                .and()
                .withPathInput("path1")
                .name("Path1")
                .and()
                .withSingleItemSelector("single1")
                .name("Single1")
                .selectItems(single1SelectItems)
                .and()
                .withMultiItemSelector("multi1")
                .name("Multi1")
                .selectItems(multi1SelectItems)
                .and()
                .build();
        flow.run();
    }

    @ShellMethod(key = "component string", value = "String input", group = "Components")
    public String stringInput(boolean mask) {
        StringInput component = new StringInput(getTerminal(), "Enter value", "myvalue");
        component.setResourceLoader(getResourceLoader());
        component.setTemplateExecutor(getTemplateExecutor());
        if (mask) {
            component.setMaskCharacter('*');
        }
        StringInput.StringInputContext context = component.run(StringInput.StringInputContext.empty());
        return "Got value " + context.getResultValue();
    }

    @ShellMethod(key = "component single", value = "Single selector", group = "Components")
    public String singleSelector(
            @ShellOption(defaultValue = ShellOption.NULL) Boolean longKeys
    ) {
        List<SelectorItem<String>> items = new ArrayList<>();
        items.add(SelectorItem.of("key1", "value1"));
        items.add(SelectorItem.of("key2", "value2"));
        if (longKeys != null && longKeys) {
            items.add(SelectorItem.of("key3 long long long long long", "value3"));
            items.add(SelectorItem.of("key4 long long long long long long long long long long", "value4"));
        }
        SingleItemSelector<String, SelectorItem<String>> component = new SingleItemSelector<>(getTerminal(),
                items, "testSimple", null);
        component.setResourceLoader(getResourceLoader());
        component.setTemplateExecutor(getTemplateExecutor());
        SingleItemSelector.SingleItemSelectorContext<String, SelectorItem<String>> context = component
                .run(SingleItemSelector.SingleItemSelectorContext.empty());
        String result = context.getResultItem().flatMap(si -> Optional.ofNullable(si.getItem())).get();
        return "Got value " + result;
    }
}
