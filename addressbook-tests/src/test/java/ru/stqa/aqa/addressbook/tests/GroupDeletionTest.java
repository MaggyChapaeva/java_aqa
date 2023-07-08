package ru.stqa.aqa.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.aqa.addressbook.model.GroupData;

public class GroupDeletionTest extends TestBase{

  @Test
  public void testGroupDeletion() throws Exception {

    app.getNavigationsHelper().gotoGroupPage();
    int before = app.getGroupHelper().getGroupCount();
    if(!app.getGroupHelper().isThereAGroup()){
      app.getGroupHelper().createGroup(new GroupData("test1", null, null));
    }
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().deleteSelectedGroup();
    app.getGroupHelper().returnToGroupPage();
    int after = app.getGroupHelper().getGroupCount();
    Assert.assertEquals(after, before - 1);
  }
}
