# CatApp

Esse Projeto utiliza as seguintes bibliotecas: 
Retroft ( para REST)
Moshi   ( para fazer o parser do Json ) 
coil    ( para fazer o carregamento das imagens através da internet ) 
  

Utilizando a arquitetura de corotinas e viewModel como sugerida  pela documentacao oficial do Android. 
A classe MainActivity é a classe da tela principal,
ela possui um RecyclerViewer  para fazer a apresentação  das imagens que sao carregadas pelo model (MainViewModel). 
O Model é resposável para fazer o carregamento dos dados através de corotinas chamando os serviçoes rest da api do ImgURL.
