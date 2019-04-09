# caffeine
um java web framework para brasileiros

por que?

- em sua maioria existem vários frameworks java web gringos; 
- temos uma série de particularidades em termos de negócio;
- funcionalidades que facilmente poderiam se tornar componentes são reescritos, gerando possíveis erros;
- normalmente o desenvolvedor necessita se adaptar ao modelo de construção do framework e, dependendo da curva de aprendizado, o negócio deixa de ser o propósito;
- frameworks tradicionais oferecem funcionalidades além do necessário, gerando uma possivel redução de desempenho.

por que eu não usaria um framework já consolidado no mercado?

você pode usar qualquer framework, porém, considere a curva de aprendizado e se realmente faz sentido gastar tanto tempo entendendo conceitos
que já poderiam vir abstraídos do desenvolvedor pelo Caffeine:

- pense como você implementa o fluxo de nevegação, 
- quantos descritores (XML/Anotações) você precisa definir, 
- quantas páginas HTML/CSS + ManagedBean você precisa criar.
- por que você precisa se preocupar tanto com escopos como: session, request, etc?
- como passar parâmetros de uma tela para outra?
- por que é comum colocar negócio dentro de apresentação e se torna difícil definir uma fronteira?

...permitindo que você foque exatamente no négocio da sua aplicação.

**diferenciais**

- 100% java, sem necessidade de conhecimentos em HTML, CSS, Javascript, ...
- uma linguagem para a construção de paginas e formularios em portugues;
- simplificação na configuração e aprendizado;
- componentes como CPF, CNPJ conforme os padrões brasileiros;
- flexivel, sendo possível criar seus próprios componentes;
- gratuíto, livre e de uso irrestrito.

abraços.
