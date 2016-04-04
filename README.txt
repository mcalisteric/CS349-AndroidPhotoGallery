This app was tested in Genymotion.
To load an image from a URL, click to "Search" floating action button.
To load the preset images (3 gifs, 3 pngs, 4 jpgs), click the gallery icon in the toolbar.
To clear the images added, click the delete (red x) icon.
MVC is used between the FotoModel class and FotoAdapter. As FotoInfo(image info) is added to a list in FotoModel, FotoAdapter's udpate method is called, which creates a list of bitmaps that the using the data in the model, which are then added to a GridView.