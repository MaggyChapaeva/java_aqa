package ru.stqa.aqa.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.aqa.addressbook.model.GroupData;

public class GroupCreationTests extends TestBase{

  @Test
  public void testGroupCreation() throws Exception {
    app.getNavigationsHelper().gotoGroupPage();
    int before = app.getGroupHelper().getGroupCount();
    app.getGroupHelper().createGroup(new GroupData("test1", null, null));
    int after = app.getGroupHelper().getGroupCount();
    Assert.assertEquals(after, before + 1);
  }
}
