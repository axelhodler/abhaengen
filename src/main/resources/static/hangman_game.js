{
  let template = document.createElement('template')
  template.innerHTML = `
    <h1>
        Hangman
    </h1>
    <div>
        Game: <span id="game-id"></span>
    </div>
    <div>
        Status: <span id="game-placeholder"></span>
    </div>
    <input id="game-pickedletter"
           type="text"
           maxlength="1"/>
    <button id="game-pick">Pick</button>
`

  class Hangman extends HTMLElement {
    constructor() {
      super()
      let templateContent = template.content
      const shadowRoot = this.attachShadow({mode: 'open'})
        .appendChild(templateContent.cloneNode(true))
    }

    connectedCallback() {
      let pickButton = this.shadowRoot.querySelector('#game-pick')
        .addEventListener("click", this)
      fetch('game', {
          method: 'POST'
        })
        .then(resp => resp.json())
        .then(game => {
          this.shadowRoot.querySelector('#game-id')
            .innerHTML = game.game_id
          this.shadowRoot.querySelector('#game-placeholder')
            .innerHTML = game.placeholder
        });
    }

    handleEvent(event) {
      let gameId = this.shadowRoot.querySelector('#game-id').innerHTML
      let pick = this.shadowRoot.querySelector('#game-pickedletter').value
      fetch(`game/${gameId}`, {
          method: 'PATCH',
          headers: {
            "Content-Type": "application/json"
          },
          body: JSON.stringify({
            "pick": pick
          })
        })
        .then(resp => resp.json())
        .then(game => {
          gameId = game.game_id
          this.shadowRoot.querySelector('#game-placeholder')
            .innerHTML = game.placeholder
        });
    }
  }

  customElements.define('hangman-game', Hangman)
}