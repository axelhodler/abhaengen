package co.hodler.hang

org.springframework.cloud.contract.spec.Contract.make {
    request {
        method PATCH()
        url("/game/1")
        body([
            pick: "r"
        ])
        headers {
            header('Content-Type', 'application/json')
        }
    }

    response {
        status 200
        body([
            placeholder: "_r__"
        ])
    }
}
