public class MouseController {
   public static void main(String[] args) {
      MouseModel model = new MouseModel();
      MouseView view = new MouseView(model.getImage());
      view.addClosingListener(new java.awt.event.WindowAdapter() {
          @Override
          public void windowClosing(java.awt.event.WindowEvent windowEvent) {
              int answer = view.getClosingAnswer();
              if (answer == 0) {
                  System.exit(0);
              }
              if(answer == 1) {
                  view.getCommand();
              }
              if(answer == -1) {
                  view.getCommand();
              }
          }
      });
      model.setXPos(20);
      model.setYPos(20);
      view.setXPos(model.getXPos());
      view.setYPos(model.getYPos());
      view.setImageLeft(model.getImageLeft());
      view.setImageRight(model.getImageRight());
      view.setImageUp(model.getImageUp());
      view.setImageDown(model.getImageDown());
      view.getCommand();
      model.setCurrentImage(view.getImage());
   }
}