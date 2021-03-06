# caffeine
**um java web framework em português**

[![BCH compliance](https://bettercodehub.com/edge/badge/andersonfonseka/caffeine?branch=master)](https://bettercodehub.com/)
[![Build Status](https://travis-ci.org/andersonfonseka/caffeine.svg?branch=master)](https://travis-ci.org/andersonfonseka/caffeine)
[![Coverage Status](https://coveralls.io/repos/github/andersonfonseka/caffeine/badge.svg?branch=master)](https://coveralls.io/github/andersonfonseka/caffeine?branch=master)
[![Maintainability](https://api.codeclimate.com/v1/badges/1b04df63b43520cd6bbc/maintainability)](https://codeclimate.com/github/andersonfonseka/caffeine/maintainability)

**por que?**

- em sua maioria existem vários frameworks java web gringos; 
- temos uma série de particularidades em termos de negócio;
- funcionalidades que facilmente poderiam se tornar componentes são reescritos, gerando um maior esforço de construção e a introdução de possíveis erros;
- normalmente o desenvolvedor precisa se adaptar ao modelo de construção do framework e, dependendo da curva de aprendizado, o negócio deixa de ser o propósito;
- frameworks tradicionais oferecem funcionalidades além do necessário, gerando uma possivel redução de desempenho;
- falamos em qualidade no desenvolvimento, porém, nem sempre é possível saber se o framework utilizado possui uma qualidade adequada.

**por que eu não usaria um framework já consolidado no mercado?**

você pode usar qualquer framework, porém, considere a curva de aprendizado e se realmente faz sentido gastar tanto tempo entendendo conceitos
que já poderiam vir abstraídos do desenvolvedor pelo Caffeine:

- pense como você implementa o fluxo de navegação, 
- quantos descritores (XML/Anotações) você precisa definir, 
- quantas páginas HTML/CSS + ManagedBean você precisa criar.
- por que você precisa se preocupar tanto com escopos como: session, request, etc?
- como passar parâmetros de uma tela para outra?
- por que é comum colocar negócio dentro de apresentação e se torna difícil definir uma fronteira?

...permitindo que você foque exatamente no négocio da sua aplicação.

**diferenciais**

- 100% java, sem necessidade de conhecimentos em HTML, CSS, Javascript, ...
- uma linguagem para a construção de paginas e formularios em português;
- simplificação na configuração do projeto 
- menor curva de aprendizado;
- componentes que vão além caixas de entrada e exibição previstos na maioria dos frameworks generalistas;
- flexivel, sendo possível criar seus próprios componentes;
- gratuíto, livre e de uso irrestrito;
- a qualidade é um dos principais focos do framework. 

abraços.
