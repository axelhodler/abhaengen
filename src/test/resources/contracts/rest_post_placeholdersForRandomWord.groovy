package co.hodler.hang

org.springframework.cloud.contract.spec.Contract.make {
    request {
        method POST()
        url("/game")
    }

    response {
        status 200
        body([
            game_id    : anyNonBlankString(),
            placeholder: "____"
        ])
    }
}
